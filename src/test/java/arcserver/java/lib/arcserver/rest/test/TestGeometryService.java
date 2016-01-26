package arcserver.java.lib.arcserver.rest.test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import arcserver.java.lib.arcserver.geometry.Point;
import arcserver.java.lib.arcserver.geometry.Polygon;
import arcserver.java.lib.arcserver.rest.GeometryService;


public class TestGeometryService {
	
	
	@Test
	public void initial() throws ClientProtocolException, IOException{
		GeometryService gs = new GeometryService("sampleserver6.arcgisonline.com/arcgis/rest/services/Utilities/Geometry/GeometryServer");
		String coordinates = "{y:40.746154,x:-73.989684}";
		String geometry_params = "{geometryType:esriGeometryPoint,geometries:["+coordinates+"]}";
		List<Point> pp = new ArrayList<Point>();
		pp.add(new Point("-73.989684", "40.746154", "4326"));
		try {
			//List<Point> projections = (List<Point>) gs.project("4326", "21781", geometry_params);
			List<Point> projections = (List<Point>) gs.project("4326", "21781", pp.toArray(new Point[pp.size()]));
			assertEquals("-5366278.6595706437", projections.get(0).getX());
			assertEquals("2631617.8361056671", projections.get(0).getY());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testParams(){
		GeometryService gs = new GeometryService("sampleserver6.arcgisonline.com/arcgis/rest/services/Utilities/Geometry/GeometryServer");
		List<Point> pp = new ArrayList<Point>();
		List<Polygon> pol = new ArrayList<Polygon>();
		pol.add(new Polygon());
		pp.add(new Point("-73.989684", "40.746154", "4326"));
		gs.params(pp.toArray(new Point[pp.size()]));
		
	}
}