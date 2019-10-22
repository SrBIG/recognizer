package bsuir.ai.recognizer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RecognizeResult {
    private Integer rank;
    private Language language;
    private Document testedDocument;
    private Document foundedDocument;
}
