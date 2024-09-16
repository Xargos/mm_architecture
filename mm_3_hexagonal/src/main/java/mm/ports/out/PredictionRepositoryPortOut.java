package mm.ports.out;

import java.math.BigDecimal;
import java.time.Instant;

public interface PredictionRepositoryPortOut {

    record InstrumentDto(String name) {
    }

    record PredictionDto(
        InstrumentDto instrumentDto,
        BigDecimal prediction,
        Instant timestamp) {
    }

    void save(PredictionDto predictionDto);
}
