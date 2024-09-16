package mm;

import mm.api.PredictionApi;
import mm.service.LocalLlmService;
import mm.service.PredictionService;

public class Bootstrap {
    public static PredictionApi build() {
        return new PredictionApi(
            new PredictionService(new LocalLlmService())
        );
    }
}
