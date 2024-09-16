package mm.domain;

import java.math.BigDecimal;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import mm.ports.in.PredictionPortIn;
import mm.ports.out.LlmPortOut;
import mm.ports.out.PredictionRepositoryPortOut;

@RequiredArgsConstructor
public class PredictionService implements PredictionPortIn {

    private final LlmPortOut llmPortOut;
    private final PredictionRepositoryPortOut predictionRepositoryPortOut;

    @Override
    public PredictionDto predict(InstrumentDto instrumentDto) {
        var query = "Predict the price of " + instrumentDto.name();
        var result = llmPortOut.inference(query);
        var prediction = new PredictionDto(new BigDecimal(result));
        predictionRepositoryPortOut.save(new PredictionRepositoryPortOut.PredictionDto(
            new PredictionRepositoryPortOut.InstrumentDto(instrumentDto.name()),
            prediction.value(),
            Instant.now()
        ));
        return prediction;
    }
}
