package arcserver.java.lib.arcserver.geometry;

public class Polygon extends Geometry{

	private static String geometryType = "esriGeometryPolygon";
	
	public Polygon(){
		super(geometryType);
	}
	
	public String getGeometryType() {
		return geometryType;
	}
}
