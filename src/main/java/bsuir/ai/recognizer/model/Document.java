package bsuir.ai.recognizer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "document")
public class Document {
    @Id
    @Column(name = "document_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentId;

    @Column(name = "document_text", nullable = false)
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_lang", nullable = false)
    private Language language;

    @ElementCollection
    @CollectionTable(name = "gram_count", joinColumns = @JoinColumn(name = "document_id"))
    @MapKeyColumn(name = "gram")
    @Column(name = "count")
    private Map<String, Integer> gramWeight;
}
