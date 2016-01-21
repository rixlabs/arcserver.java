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
		String geometry_params = URLEncoder.encode("{geometryType:esriGeometryPoint,geometries:["+coordinate+"]}", "UTF-8");
		String url = "http://srvgists011:6080/arcgis/rest/services/Utilities/Geometry/GeometryServer/project?inSR=4326&outSR=21781&geometries="+geometry_params+"&f=json";
		System.out.println(url);
		gs.execute(url);
		
	}
}