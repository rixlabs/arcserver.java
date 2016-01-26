package arcserver.java.lib.arcserver.geometry;

public class Point extends Geometry {

	private transient static String geometryType = "esriGeometryPoint";
	private String x;
	private String y;
	private transient String spatialReference;
	
	public Point(String x,String y, String spatialReference){
		super(geometryType);
		this.x = x;
		this.y = y;
		this.spatialReference = spatialReference;
	}
	
	

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getSpatialReference() {
		return spatialReference;
	}

	public void setSpatialReference(String spatialReference) {
		this.spatialReference = spatialReference;
	}
	
}
