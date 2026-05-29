package garden_management_api.weather.dto;

public class WeatherResponseDTO {

    private Current current;

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public static class Current {

        private Double temperature_2m;
        private Integer relative_humidity_2m;

        public Double getTemperature_2m() {
            return temperature_2m;
        }

        public void setTemperature_2m(Double temperature_2m) {
            this.temperature_2m = temperature_2m;
        }

        public Integer getRelative_humidity_2m() {
            return relative_humidity_2m;
        }

        public void setRelative_humidity_2m(Integer relative_humidity_2m) {
            this.relative_humidity_2m = relative_humidity_2m;
        }
    }
}