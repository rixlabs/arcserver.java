package arcserver.java.lib.arcserver.rest.test;
import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import arcserver.java.lib.arcserver.rest.GeometryService;


public class TestGeometryService {
	
	@Test
	public void initial() throws ClientProtocolException, IOException{
		GeometryService gs = new GeometryService();
		String coordinate = "{y:46.036374,x:8.980354}";
		String coordinates = "{y:40.746154,x:-73.989684}";
		String geometry_params = URLEncoder.encode("{geometryType:esriGeometryPoint,geometries:["+coordinates+"]}", "UTF-8");
		String url = "http://sampleserver6.arcgisonline.com/arcgis/rest/services/Utilities/Geometry/GeometryServer/project?inSR=4326&outSR=21781&geometries="+geometry_params+"&f=json";
		System.out.println(url);
		gs.execute(url);
		
	}
}