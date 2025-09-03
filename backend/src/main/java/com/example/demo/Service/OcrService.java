package com.example.demo.Service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;



public class OcrService {

    public static void main(String[] args) {
        OcrService ocrService = new OcrService();

        String ocrString = """
            Open » Mm *Untitled Docu... Save = - [=
            Name: Alice Doe
            Email: alice@gmail.com
            Phone no: 012345678
            age: 40
            weight: 30
            height: 158cm
            """;
        ocrService.OcrResultToJson(ocrString);
        
    }

    public String OcrResultToJson(String ocrText){

        String schema = """
        {
            "full_name": "",
            "email": "",
            "phone": "",
            "age": "",
            "weight": "",
            "height": "",
            "additional_info": ""    
        }
        """;

        String prompt = "Extract the following fields into JSON strictly following this schema:\n"
                        + schema + "\n\nOCR text:\n" + ocrText;
        
        String apiKey = System.getenv("GOOGLE_API_KEY");
        Client client = Client.builder().apiKey(apiKey).build();

        GenerateContentResponse response = client.models.generateContent("gemini-2.5-flash", prompt, null);

        System.out.println("Response " + response.text());
        return "";
        
    }
    
}
