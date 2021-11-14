package com.wolfpack.vision.rest;

import org.springframework.stereotype.Service;

@Service
public class RestURL {


    private static final String INRIX_API_KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhcHBJZCI6ImoweDcyMTR4NTgiLCJ0b2tlbiI6eyJpdiI6ImNhNGU1MjNmMTU0ZmJjOGY0MmQ4OTk2Mjk1NmVmYTE1IiwiY29udGVudCI6ImU1Y2UyY2FkZDQzN2I1MGFmYWY4NTg3NjdlYjYwMWEyZTE5OTBiNmI0NTUwZDI0NzA1NjNhZGQ3MjljMjlkMTY1MGI1MjczOWY3NzM2ODU0ZmI3ZTllYzVhZDEzODU1MmE2ZDE5YWZiNzk3ZjhjMmY5OWUyMzNkMjllZmM0NzhhMzJiNWY1N2RmMjE3YWU3ODAzN2NkYTk1M2Q1MTQ4MzQzZDU0NzI3Mjg2YjgyZGMzYjYxODI3NjRiYTY2MWZmZjkyZTFiZjBjNGMzODY3ODBiYjRlYjcwMmYzZDAzZjM2MjNkODkzNzk5MzlhODEzYmYzOWU5ZjM4Yjk1ZTA2M2NiZWY2NjM3OTY0OTFmZjA1MzdjMGU1YTlmMDA5YWM5NDI1MDBmN2IwNmIwZDMwM2Q5NWVjMWRlMmM2NmU5MzU1OTc4MjJmM2M0NDQ0NWNjYTYyZjMwNWZkMzgwMGEyNzVkZjBmNmEwOGRiNTZkMTUxOTJhMWVkYjZjOWVhYmQ4ZDU4NDZhZWEwODQ4NWQ3NWMxNDAxZGM5M2ZmM2FlZWU1YTIzMjE4MGJmM2IwN2FmMWM0OGZjMTAwOGFiYTY0MjgxN2I1NWQ3YzhiMjAxM2VhMDQ4NzFhNzA5YmE5MjAzYzI0ZWRmZTI2MDE3MmZiMjdmOTVkYTY2YzhlZGFlMWRiMjlkZGRkZWQwNjAyZTA0ZWY0Yzg1ZmZlMTRiZDdiYzU1N2ZjMjk1MGJlZDU4Njc0MDY4ZDUzZTM1NGYyZDQ4NjE5ZmUxYjk1ZTA0MTg2ZTEzNGI2YzU5MWE4ZDEyY2EyZWU1NDdjZDc2ZjE5NTczYjkwZGJmYzc3OWJiYzQ5NTJmMzk5ZjllZjk2NGIwODRlZTRiYzYzIn0sInNlY3VyaXR5VG9rZW4iOnsiaXYiOiJjYTRlNTIzZjE1NGZiYzhmNDJkODk5NjI5NTZlZmExNSIsImNvbnRlbnQiOiJjNGM0MDg4OTg2MDViNzBlZTFkODY2NWU0MGZmMjRkZmU2ODI3YTcyNDI3NGYyMzUyODYzYWZiMzE4OWNkNTNhNjFhNzM0NThhOTVjNDcyZGZiNTRiOWZiIn0sImp0aSI6Ijc3OWE4OGYyLTIzY2YtNDQwNS04MDk4LWE3Y2MyYTU1MmNiZCIsImlhdCI6MTYzNjg5OTM0MywiZXhwIjoxNjM2OTAyOTQzfQ.ZjJ5nwEroYVXuKyqO7l_d79BTV238Pm2cmz3-shK8eM";

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
