package com.wolfpack.vision.rest;

import org.springframework.stereotype.Service;

@Service
public class RestURL {


    private static final String INRIX_API_KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhcHBJZCI6ImoweDcyMTR4NTgiLCJ0b2tlbiI6eyJpdiI6IjAyMDM2ZjMwNzkwZTViNDhiZDY3MjkxYWQ0MzA3MzA2IiwiY29udGVudCI6ImE4ODkyNmMzY2I4M2JlYzIwYzE5MWVjM2NmOTExM2Q5MWNiYTVlM2Y0MGYzNTdlM2NlMmI3YmFiNDU1NDA1Y2Y1ZTJmNmIzZmFmYTVjYWVjMDYwZjk1ZWNjMTIxMmVjYjM4N2RhNDViNmVjNWMwMzM4NTI0NmFiYTAwNGQyNDBlYjM3MjA4NTQwMzY0Y2VjZTdiMTlmNDQ4NWRkMWVjYzBmMzg0NDcwNWI3ZDlhMjI3NmUwNGJmNDdjOWIwODRjNGQwYzMyYmYxMGRkOWZhYzk2YjMyZjIyMWViZmQyNGE4NjRlMGIwZjY5MDQ5OGU3ZGQxY2JhYjBhNTlhYTg1MTE2MzlhY2U2NWQ0ODg1NGJlMGQ2YzM4MDE0ZGVmY2YyMDgxMDI1OGY5YmY2ZTIyNWEzMjQ5MzNjZWQwMWQzNTJhYzNlODU1YzY1MGFkNTlhNzE2NDkzMWU3MTkyMTIxN2Q2NzFmZjI4OTA1NGYzN2VhODk4ZDNmYTU5OTJkYjc1OWMzMWU3MGI4ZWRiZjA2MjA0MjU1NDIyODBjOTE2ZTZhNjE5NmY3NjZlMDA0MzI2OTQyNjQ3ZWQ1YzcyOWYwNTU0ZWJmMWIwODZlYjBjM2YyODI0ODUwMGYyYTZhMGM0NDU2YzhlM2M2YzgwOTE5MmUwOTBiOGM0YWQwNjljMjFmMmQ5N2FmM2RlNjY5ZjBmNjgzNTEzMTVmZjlhMDBlNjIxM2FkMDFjOTliZDY0Y2E0ODg4YzkwMTkxNjlkNjA2NjVhMmRhYjI4MzdkZTdmMTUwYjc0MTQ3YWQ4NTBjNjUwMjA3ZjdmNTgzYjI3Njk2ZjI5OWUzOTY4OGIyZTQ4Yzc2YTA1Y2IzMDYxMzRmYjA4OTE3YWUyIn0sInNlY3VyaXR5VG9rZW4iOnsiaXYiOiIwMjAzNmYzMDc5MGU1YjQ4YmQ2NzI5MWFkNDMwNzMwNiIsImNvbnRlbnQiOiI5YTgzMDFmOWRmYTBhODlmNzYzZjA2ZjhkZjg2MmU5YTc4ZTE3MDdlNmRkNzdmODNkODVmNWNmZjc4NWQ0N2NlNmMxZTEzNDVjNGFhYzNmNjFiMDg5OGQyIn0sImp0aSI6ImUwODYyYmM5LTgwYjQtNDVlNy1iYzUwLTVhMzIzZjUwZDg2NCIsImlhdCI6MTYzNjg5NTYzMSwiZXhwIjoxNjM2ODk5MjMxfQ.c9I-q2Iaotoj3Vset4FPxeX9zpIVXOUo1FzZSGeVSFE";

    private static final String INRIX_BASE_URL = "https://api.iq.inrix.com";
    private static final String INRIX_APP_TOKEN = "/auth/v1/appToken";
    private static final String INRIX_FIND_ROUTE = "https://api.iq.inrix.com/findRoute";


    private static final String FOUR_SQUARE_BASE_URL = "https://api.foursquare.com";

    private static final String FOUR_SQUARE_VENUE_URL = "/v2/venues/explore";


    public RestURL(){

    }

    public String getApplicationTokenApiEndPoint(){
        return INRIX_BASE_URL + INRIX_APP_TOKEN;
    }

    public String getFourSquareVenuesApiEndpoint() {
        return FOUR_SQUARE_BASE_URL + FOUR_SQUARE_VENUE_URL;
    }

    public String getFindRouteEndpoint(){
        return INRIX_FIND_ROUTE;
    }

    public String getInrixApiKey(){
        return INRIX_API_KEY;
    }

}
