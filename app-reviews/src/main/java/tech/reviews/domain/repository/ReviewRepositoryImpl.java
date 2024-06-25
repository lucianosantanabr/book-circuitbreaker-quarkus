package tech.reviews.domain.repository;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import tech.reviews.domain.entity.Review;

@ApplicationScoped
public class ReviewRepositoryImpl implements ReviewRepository {

  private static long id = 1;
  private static final List<Review> REVIEWS = new ArrayList<>();

  static {
    REVIEWS.add(
        new Review(
            nextId(),
            10,
            "Ótimo livro de refatoração contendo vários exemplos com codigo para poder acompanhar e aprimorar ",
            "Pedro Junio",
            1L));
    REVIEWS.add(
        new Review(nextId(), 10, "Acabei de ler o livro, muito bacana.", "Luca Guerra", 1L));
    REVIEWS.add(
        new Review(
            nextId(),
            10,
            "Livro com boas explicações de uma linguagem bem objetiva trazendo muito para a realidade.",
            "Maria",
            1L));
    REVIEWS.add(
        new Review(
            nextId(),
            10,
            "Este livro fala da importância de manter o código limpo e livre de informações irrelevantes para o sistema, mantendo métodos e classes com nomes relevantes que não necessitem de explicações. Além de citar padrões e práticas de outros autores como os maus cheiros de Martin Fowler. Esse livro explica como funciona o famoso acrônimo S.O.L.I.D entre os desenvolvedores.",
            "Alexandre",
            2L));
    REVIEWS.add(
        new Review(
            nextId(),
            5,
            "Um ótimo livro para auxiliar que estão aprendendo a programar e pra aqueles que já estão a bastante tempo no mercado.",
            "Alex",
            2L));
    REVIEWS.add(
        new Review(
            nextId(),
            8,
            "Este livro é o mais excelente sobre práticas e habilidades em programação",
            "Alex",
            2L));
    REVIEWS.add(
        new Review(
            nextId(),
            5,
            "O livro compartilha muitas práticas recomendadas - tanto do ponto de vista de escrever código de teste quanto de como as equipes devem trabalhar para escrever casos de teste de forma colaborativa. Espero implementá-los em nossa organização..",
            "Marcelo",
            3L));
    REVIEWS.add(
        new Review(
            nextId(),
            5,
            "O título do livro pode levar a crer que seu conteúdo é apenas para pessoas que utilizam a ferramenta Cucumber para BDD com Ruby, quando na verdade os autores cobrem a maior parte de seus tópicos de tal forma que a maioria dos princípios podem ser aplicados a qualquer BDD. ferramenta e linguagem de programação que se está usando",
            "Arthur",
            3L));
    REVIEWS.add(
        new Review(
            nextId(),
            5,
            "O resultado líquido da leitura deste livro é que você sente que usou a tecnologia e entende por que ela é assim. Eu teria preferido um pouco mais de ênfase nos padrões e que houvesse uma seção sobre a abordagem agora mais padrão baseada em Cucumber JVM. No entanto, este livro ainda é eminentemente legível e compreensível, mesmo para quem não é especialista em Ruby.",
            "Fernada",
            3L));
  }

  @Override
  public void save(Review review) {
    review.setId(nextId());
    REVIEWS.add(review);
  }

  @Override
  public List<Review> getAll() {
    return new ArrayList<>(REVIEWS);
  }

  @Override
  public Optional<Review> getOne(Long id) {
    return REVIEWS.stream().filter(review -> review.getId().equals(id)).findFirst();
  }

  @Override
  public List<Review> getReviewsOfBook(Long bookId) {
    return REVIEWS.stream().filter(r -> r.getBookId().equals(bookId)).toList();
  }

  private static Long nextId() {
    return id++;
  }
}
