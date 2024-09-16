package mm;

import mm.adapters.llm.ExternalLlmAdapter;
import mm.adapters.storage.PredictionRepositoryAdapter;
import mm.api.PredictionApi;
import mm.domain.PredictionService;

public class Bootstrap {
    public static PredictionApi build() {
        return new PredictionApi(
            new PredictionService(new ExternalLlmAdapter(), new PredictionRepositoryAdapter())
        );
    }
}
