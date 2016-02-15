package view;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;

import model.Ball;
import model.Coordinate;
import model.IElement;
import model.Gizmos.Absorber;
import model.Gizmos.Circle;
import model.Gizmos.Flipper;
import model.Gizmos.Square;
import model.Gizmos.Triangle;
import model.Gizmos.Wall;

public class Shapifier {

	private static HashMap<Class<? extends IElement>, ShapeMaker> shapeMakerMap;

	private BoardView boardView;

	public Shapifier(BoardView boardView) {
		setBoardView(boardView);
		
		initialiseShapeMakerMap();
	}

	public Shape shapify(IElement e) {
		ShapeMaker shapeMaker = shapeMakerMap.get(e.getClass());

		int horizontalScalingFactor = boardView.getHorizontalScalingFactor();
		int verticalScalingFactor = boardView.getVerticalScalingFactor();

		Coordinate originCoordinate = e.getOrigin();

		double originX = originCoordinate.getX()* horizontalScalingFactor;
		double originY = originCoordinate.getY()* verticalScalingFactor;

		Coordinate boundingCoordinate = e.getBound();
		double boundX = boundingCoordinate.getX()* horizontalScalingFactor;
		double boundY = boundingCoordinate.getY()* verticalScalingFactor;


		double width = (boundX - originX);
		double height = (boundY - originY);

		Shape shape = shapeMaker.make((int) originX, (int) originY, (int) width, (int) height);
		
		return shape;
	}

	private void initialiseShapeMakerMap() {
		shapeMakerMap = new HashMap<>();

		shapeMakerMap.put(Absorber.class, (int x, int y, int w, int h) -> {
			return new Rectangle(x, y, w, h);
		});

		shapeMakerMap.put(Circle.class, (int x, int y, int w, int h) -> {
			return new Ellipse2D.Double(x, y, w, h);
		});

		// TODO: does this one actually work?
		shapeMakerMap.put(Flipper.class, (int x, int y, int w, int h) -> {
			return new Rectangle(x, y, w, h);
		});

		shapeMakerMap.put(Square.class, (int x, int y, int w, int h) -> {
			return new Rectangle(x, y, w, h);
		});

		shapeMakerMap.put(Triangle.class, (int x, int y, int w, int h) -> {
			// TODO: return a triangle
			return new Rectangle(x, y, w, h);
		});

		shapeMakerMap.put(Wall.class, (int x, int y, int w, int h) -> {
			return new Rectangle(x, y, w, h);
		});

		shapeMakerMap.put(Ball.class, (int x, int y, int w, int h) -> {
			return new Ellipse2D.Double(x, y, w, h);
		});
	}

	private void setBoardView(BoardView boardView) {
		this.boardView = boardView;
	}

	private interface ShapeMaker {
		public Shape make(int x, int y, int w, int h);
	}
}