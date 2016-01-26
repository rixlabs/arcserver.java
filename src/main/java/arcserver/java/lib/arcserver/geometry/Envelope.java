package arcserver.java.lib.arcserver.geometry;

public class Envelope extends Geometry{
	
	private static String geometryType = "esriGeometryEnvelope";
	
	public Envelope(){
		super(geometryType);
	}
	
	
	public String getGeometryType() {
		return geometryType;
	}
}
