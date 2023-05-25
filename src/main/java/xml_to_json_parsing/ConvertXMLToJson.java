package xml_to_json_parsing;


import org.json.JSONObject;
import org.json.XML;

public class ConvertXMLToJson {
    public static void convert(String xmlFile){
        JSONObject json= XML.toJSONObject(xmlFile);
        System.out.println(json);
    }
}
