package mm.service;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import mm.service.model.Instrument;
import mm.service.model.Prediction;

@RequiredArgsConstructor
public class PredictionService {

    private final LocalLlmService localLlmService;

    public Prediction predict(Instrument instrument) {
        var query = "Predict the price of " + instrument.name();
        var result = localLlmService.inference(query);
        return new Prediction(new BigDecimal(result));
    }
}
