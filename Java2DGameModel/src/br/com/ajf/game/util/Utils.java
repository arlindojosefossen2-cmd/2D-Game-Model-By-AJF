package br.com.ajf.game.util;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;
import java.util.List;

import br.com.ajf.game.math.Matrix3x3F;
import br.com.ajf.game.math.Vector2F;

/**
 * The Class Utils.
 */
public final class Utils
{
    
    /**
     * Instantiates a new utils.
     */
    private Utils()
    {

    }

    /**
     * Draw centered text.
     *
     * @param graphics2D the graphics 2 D
     * @param w the w
     * @param y the y
     * @param text the text
     * @return the int
     */
    public static int drawCenteredText(final Graphics2D graphics2D,final int w,final int y,final String text)
    {
        return drawCenteredText(graphics2D,w,y,new String[]{text});
    }

    /**
     * Draw centered text.
     *
     * @param graphics2D the graphics 2 D
     * @param w the w
     * @param y the y
     * @param texts the texts
     * @return the int
     */
    public static int drawCenteredText(final Graphics2D graphics2D,final int w,final int y,final List<String> texts)
    {
        return drawCenteredText(graphics2D,w,y,texts.toArray(new String[0]));
    }

    /**
     * Draw centered text.
     *
     * @param graphics2D the graphics 2 D
     * @param w the w
     * @param y the y
     * @param texts the texts
     * @return the int
     */
    public static int drawCenteredText(final Graphics2D graphics2D,final int w, int y,final String... texts)
    {
       final FontMetrics fm = graphics2D.getFontMetrics();

       final int height = fm.getAscent() + fm.getLeading() + fm.getDescent();

        for(final String txt : texts)
        {
           final Rectangle2D bounds = graphics2D.getFontMetrics().getStringBounds(txt,graphics2D);

           	final int x = (w - (int)bounds.getWidth())/2;
            graphics2D.drawString(txt,x,y+fm.getAscent());
            y += height;
        }
        return y;
    }

    /**
     * Draw text.
     *
     * @param graphics2D the graphics 2 D
     * @param xPos the x pos
     * @param yPos the y pos
     * @param text the text
     * @return the int
     */
    public static int drawText(final Graphics2D graphics2D,final int xPos,final int yPos,final String text)
    {
        return drawText(graphics2D,xPos,yPos,new String[] {text});
    }

    /**
     * Draw text.
     *
     * @param graphics2D the graphics 2 D
     * @param xPos the x pos
     * @param yPos the y pos
     * @param texts the texts
     * @return the int
     */
    public static int drawText(final Graphics2D graphics2D,final int xPos,final int yPos,final List<String> texts)
    {
        return drawText(graphics2D,xPos,yPos,texts.toArray(new String[0]));
    }

    /**
     * Draw text.
     *
     * @param graphics2D the graphics 2 D
     * @param xPos the x pos
     * @param yPos the y pos
     * @param texts the texts
     * @return the int
     */
    public static int drawText(final Graphics2D graphics2D,final int xPos,int yPos,final String... texts)
    {
        final FontMetrics fm = graphics2D.getFontMetrics();

        final int height = fm.getAscent() + fm.getDescent() + fm.getLeading();

        for (final String text: texts)
        {
            graphics2D.drawString(text,xPos,yPos+fm.getAscent());
            yPos += height;
        }
        return yPos;
    }

    /**
     * Fill polygon.
     *
     * @param graphics2D the graphics 2 D
     * @param polygon the polygon
     */
    public static void fillPolygon(final Graphics2D graphics2D,final List<Vector2F> polygon)
    {
        final Polygon auxPolygon = new Polygon();

        for (final Vector2F vector2f : polygon)
        {
            auxPolygon.addPoint((int)vector2f.x,(int)vector2f.y);
        }

        graphics2D.fill(auxPolygon);
    }

    /**
     * Fill polygon.
     *
     * @param graphics2D the graphics 2 D
     * @param polygon the polygon
     */
    public static void fillPolygon(final Graphics2D graphics2D,final Vector2F[] polygon)
    {
    	final Polygon auxPolygon = new Polygon();

        for (final Vector2F vector2f : polygon)
        {
            auxPolygon.addPoint((int)vector2f.x,(int)vector2f.y);
        }

        graphics2D.fill(auxPolygon);
    }

    /**
     * Creates the viewport.
     *
     * @param worldWidth the world width
     * @param worldHeight the world height
     * @param screenWidth the screen width
     * @param screenHeight the screen height
     * @return the matrix 3 x 3 F
     */
    public static Matrix3x3F createViewport(final float worldWidth,final float worldHeight,final float screenWidth,final float screenHeight)
    {
        final float sx = (screenWidth-1)/worldWidth;
        final float sy = (screenHeight-1)/worldHeight;

        final float tx = (screenWidth - 1)/2.0f;
        final float ty = (screenHeight-1)/2.0f;

        Matrix3x3F viewport = Matrix3x3F.scale(sx,-sy);
        viewport = viewport.mul(Matrix3x3F.translate(tx,ty));

        return viewport;
    }

    /**
     * Creates the reverse viewport.
     *
     * @param worldWidth the world width
     * @param worldHeight the world height
     * @param screenWidth the screen width
     * @param screenHeight the screen height
     * @return the matrix 3 x 3 F
     */
    public static Matrix3x3F createReverseViewport(final float worldWidth,final float worldHeight,final float screenWidth,final float screenHeight)
    {
       final float sx = worldWidth/(screenWidth-1);
       final float sy = worldHeight/(screenHeight-1);

       final float tx = (screenWidth - 1)/2.0f;
       final float ty = (screenHeight - 1)/2.0f;

       Matrix3x3F viewport = Matrix3x3F.translate(-tx,-ty);
       viewport = viewport.mul(Matrix3x3F.scale(sx,-sy));

        return viewport;
    }

    /**
     * Draw polygon.
     *
     * @param graphics2D the graphics 2 D
     * @param polygon the polygon
     */
    public static void drawPolygon(final Graphics2D graphics2D,final Vector2F[] polygon)
    {
        Vector2F auxVector2f = polygon[polygon.length-1];

        for (final Vector2F position : polygon)
        {
            graphics2D.drawLine((int)auxVector2f.x,(int)auxVector2f.y,(int)position.x,(int)position.y);
            auxVector2f = position;
        }
    }
    
    /**
     * Draw polygon.
     *
     * @param graphics2D the graphics 2 D
     * @param polygon the polygon
     */
    public static void drawPolygon(final Graphics2D graphics2D,final List<Vector2F> polygon)
    {
       Vector2F auxVector2f = polygon.get(polygon.size()-1);

        for (final Vector2F positionVector2f : polygon)
        {
            graphics2D.drawLine((int)auxVector2f.x,(int)auxVector2f.y,(int)positionVector2f.x,(int)positionVector2f.y);
            auxVector2f = positionVector2f;
        }
    }	
}