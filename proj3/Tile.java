/**
 * This is the base class for a tile.
 * Space / Cosmic theme:
 *   - Each tile is a glowing planet in deep space
 *   - Selecting a tile pulses a colored border with corner sparkles
 *   - Matching reveals a constellation and a checkmark
 * 
 * @author Sean Beckford
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;
import si211.*;

public class Tile extends JPanel {
    private Pos p;
    private int kindID;
    private boolean tileActivated = false;
    private boolean tileMatched   = false;
    private TileListener      tListener = new TileListener();
    private TileStateListener sListener;

    // --- animation state ---
    private float glowPulse  = 0f;   // 0..1, drives border brightness
    private float matchAlpha = 0f;   // 0..1, drives constellation fade-in
    private Timer pulseTimer, matchTimer;

    // Star positions – seeded so each tile always looks the same
    private int[] starX, starY;
    private float[] starSize;

    // ---------------------------------------------------------------
    // 18 vivid space palette colors, one per kindID slot
    // ---------------------------------------------------------------
    private static final Color[] SPACE_COLORS = {
        new Color(138,  43, 226),  // violet
        new Color(  0, 128, 255),  // electric blue
        new Color(255,  69,   0),  // red-orange
        new Color(  0, 206, 209),  // teal
        new Color(255, 215,   0),  // gold
        new Color( 50, 205,  50),  // lime
        new Color(255,  20, 147),  // deep pink
        new Color( 64, 224, 208),  // turquoise
        new Color(255, 140,   0),  // dark orange
        new Color(147, 112, 219),  // medium purple
        new Color(  0, 255, 127),  // spring green
        new Color(220,  20,  60),  // crimson
        new Color( 30, 144, 255),  // dodger blue
        new Color(255, 165,   0),  // orange
        new Color(  0, 250, 154),  // medium spring green
        new Color(186,  85, 211),  // medium orchid
        new Color(255,  99,  71),  // tomato
        new Color(100, 149, 237),  // cornflower
    };

    private Color theme() { return SPACE_COLORS[kindID % SPACE_COLORS.length]; }

    // ---------------------------------------------------------------
    // Inner mouse listener
    // ---------------------------------------------------------------
    private class TileListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            tileActivated = !tileActivated;
            if (tileActivated) startPulse(); else stopPulse();
            if (sListener != null && tileActivated)
                sListener.activated(Tile.this);
        }
    }

    // ---------------------------------------------------------------
    // Pulse animation – drives the glowing selection border
    // ---------------------------------------------------------------
    private void startPulse() {
        if (pulseTimer == null)
            pulseTimer = new Timer(25, e -> {
                glowPulse = (float)(Math.sin(System.currentTimeMillis() / 180.0) * 0.5 + 0.5);
                repaint();
            });
        pulseTimer.start();
    }

    private void stopPulse() {
        if (pulseTimer != null) pulseTimer.stop();
        glowPulse = 0f;
        repaint();
    }

    // ---------------------------------------------------------------
    // Seeded star field – consistent per tile
    // ---------------------------------------------------------------
    private void generateStars(int row, int col) {
        Random rng = new Random(kindID * 1000L + row * 31 + col);
        int n = 14;
        starX    = new int[n];
        starY    = new int[n];
        starSize = new float[n];
        for (int i = 0; i < n; i++) {
            starX[i]    = rng.nextInt(86) + 7;
            starY[i]    = rng.nextInt(86) + 7;
            starSize[i] = 1.2f + rng.nextFloat() * 1.8f;
        }
    }

    // ---------------------------------------------------------------
    // Public API (unchanged from original)
    // ---------------------------------------------------------------
    public void addTileStateListener(TileStateListener sl) { this.sListener = sl; }
    public void setActivated(boolean b) { tileActivated = b; if (!b) stopPulse(); }
    public int     getKindID()    { return kindID; }
    public Pos     getPos()       { return p; }
    public String  getPosString() { return p.toString(); }
    public boolean getMatched()   { return tileMatched; }
    public void disable() { removeMouseListener(tListener); }
    public void enable()  { addMouseListener(tListener); }

    public void permanentlyDisable() {
        setActivated(false);
        stopPulse();
        tileMatched = true;
        disable();
        // Animate constellation fade-in
        matchAlpha = 0f;
        matchTimer = new Timer(20, null);
        matchTimer.addActionListener(e -> {
            matchAlpha += 0.04f;
            if (matchAlpha >= 1f) { matchAlpha = 1f; matchTimer.stop(); }
            repaint();
        });
        matchTimer.start();
    }

    // ---------------------------------------------------------------
    // Painting
    // ---------------------------------------------------------------
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,     RenderingHints.VALUE_RENDER_QUALITY);

        int w = getWidth(), h = getHeight();

        if (tileMatched) { paintMatched(g2, w, h); return; }

        paintBackground(g2, w, h);
        paintStarField(g2, 0.7f);
        paintPlanet(g2, w, h);
        if (tileActivated) paintSelectionGlow(g2, w, h);
    }

    // Deep-space gradient background
    private void paintBackground(Graphics2D g2, int w, int h) {
        Color c = theme();
        Color dark = new Color(4, 4, 18);
        Color tint = new Color(c.getRed()/7, c.getGreen()/7, c.getBlue()/7 + 12);
        g2.setPaint(new GradientPaint(0, 0, dark, w, h, tint));
        g2.fillRect(0, 0, w, h);
    }

    // Tiny star dots
    private void paintStarField(Graphics2D g2, float brightness) {
        for (int i = 0; i < starX.length; i++) {
            float alpha = (i % 3 == 0 ? 0.95f : 0.55f) * brightness;
            g2.setColor(new Color(1f, 1f, 1f, alpha));
            float s = starSize[i];
            g2.fill(new Ellipse2D.Float(starX[i] - s/2, starY[i] - s/2, s, s));
        }
    }

    // Glowing planet orb
    private void paintPlanet(Graphics2D g2, int w, int h) {
        Color c    = theme();
        int   cx   = w / 2, cy = h / 2;
        int   r    = 26;

        // Soft outer glow layers
        for (int i = 7; i >= 1; i--) {
            int   rad   = r + i * 4;
            float alpha = 0.025f * i;
            g2.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), clamp(alpha)));
            g2.fillOval(cx - rad, cy - rad, rad * 2, rad * 2);
        }

        // Planet body with radial gradient (off-center highlight)
        float[] fracs = {0f, 1f};
        Color[] cols  = {c.brighter().brighter(), c.darker().darker()};
        g2.setPaint(new RadialGradientPaint(
            cx - r * 0.3f, cy - r * 0.3f, r * 1.3f, fracs, cols));
        g2.fillOval(cx - r, cy - r, r * 2, r * 2);

        // Specular highlight
        g2.setColor(new Color(255, 255, 255, 60));
        g2.fillOval(cx - r + 6, cy - r + 5, r - 4, r - 6);

        // Optional Saturn-style ring (every 3rd kindID)
        if (kindID % 3 == 0) {
            g2.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), 140));
            g2.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.drawArc(cx - r - 14, cy - 5, (r + 14) * 2, 11, 180, 180);
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawArc(cx - r - 12, cy - 4, (r + 12) * 2, 9, 0, 180);
        }
    }

    // Pulsing colored border + corner sparkles when selected
    private void paintSelectionGlow(Graphics2D g2, int w, int h) {
        Color c = theme();

        // Multi-layer soft glow
        for (int i = 6; i >= 1; i--) {
            float alpha = (glowPulse * 0.12f + 0.04f) * i;
            g2.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), clamp(alpha)));
            g2.setStroke(new BasicStroke(i * 2.5f));
            g2.drawRect(i, i, w - i * 2, h - i * 2);
        }

        // Crisp inner border
        float innerAlpha = 0.55f + glowPulse * 0.45f;
        g2.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), clamp(innerAlpha)));
        g2.setStroke(new BasicStroke(2f));
        g2.drawRect(4, 4, w - 8, h - 8);

        // Corner sparkles
        g2.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(),
            clamp(0.6f + glowPulse * 0.4f)));
        g2.setStroke(new BasicStroke(1.3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        drawSparkle(g2,  9,  9,  6);
        drawSparkle(g2, w-9, 9,  6);
        drawSparkle(g2,  9, h-9, 6);
        drawSparkle(g2, w-9, h-9, 6);
    }

    private void drawSparkle(Graphics2D g2, int x, int y, int r) {
        g2.drawLine(x - r, y, x + r, y);
        g2.drawLine(x, y - r, x, y + r);
        g2.drawLine(x - r/2, y - r/2, x + r/2, y + r/2);
        g2.drawLine(x + r/2, y - r/2, x - r/2, y + r/2);
    }

    // Constellation + checkmark reveal when matched
    private void paintMatched(Graphics2D g2, int w, int h) {
        Color c = theme();

        // Deep space base
        g2.setColor(new Color(4, 4, 18));
        g2.fillRect(0, 0, w, h);

        // Constellation lines
        g2.setStroke(new BasicStroke(0.9f));
        g2.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(),
            clamp(matchAlpha * 0.45f)));
        for (int i = 0; i < starX.length - 1; i += 2)
            g2.drawLine(starX[i], starY[i], starX[i+1], starY[i+1]);

        // Stars – brighter than unmatched, with a cross twinkle
        for (int i = 0; i < starX.length; i++) {
            float s = starSize[i] * 1.3f;
            g2.setColor(new Color(1f, 1f, 1f, matchAlpha));
            g2.fill(new Ellipse2D.Float(starX[i] - s/2, starY[i] - s/2, s, s));

            g2.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(),
                clamp(matchAlpha * 0.65f)));
            g2.setStroke(new BasicStroke(0.8f));
            int cross = (int)(s * 2);
            g2.drawLine(starX[i] - cross, starY[i], starX[i] + cross, starY[i]);
            g2.drawLine(starX[i], starY[i] - cross, starX[i], starY[i] + cross);
        }

        // Central checkmark
        int cx = w / 2, cy = h / 2;
        g2.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(),
            clamp(matchAlpha * 0.9f)));
        g2.setStroke(new BasicStroke(3.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.drawLine(cx - 13, cy + 1, cx - 3, cy + 12);
        g2.drawLine(cx - 3,  cy + 12, cx + 15, cy - 10);
    }

    // Clamp a float alpha 0..1 to an int 0..255
    private int clamp(float alpha) {
        return Math.min(255, Math.max(0, (int)(alpha * 255)));
    }

    // ---------------------------------------------------------------
    // Constructor
    // ---------------------------------------------------------------
    public Tile(int row, int col, int kindID) {
        this.p      = new Pos(row, col);
        this.kindID = kindID;

        setPreferredSize(new Dimension(100, 100));
        setBackground(new Color(4, 4, 18));
        setBorder(BorderFactory.createLineBorder(new Color(30, 30, 60), 1));

        generateStars(row, col);
        disable();
    }
}