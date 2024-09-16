package mm.ports.in;

import java.math.BigDecimal;

public interface PredictionPortIn {
    record InstrumentDto(String name) {
    }

    record PredictionDto(BigDecimal value) {
    }

    PredictionDto predict(InstrumentDto instrumentDto);
}
