package com.alura.coversorDeMonedas.principal;

public record Conversor(
        String time_last_update_utc,
        String base_code,
        String target_code,
        double conversion_result
) {

}
