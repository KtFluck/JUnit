package com.JUnitTesting.demo;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.rest.app.Book;
import com.rest.app.BookController;
import com.rest.app.BookRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

  private MockMvc mockMvc;

  ObjectMapper objectMapper = new ObjectMapper();
  ObjectWriter objectWriter = objectMapper.writer();

  @Mock
  private BookRepository bookRepository;

  @InjectMocks
  private BookController bookController;

  Book RECORD_1 = new Book(1L, "Atlis Shrugged", "A world where intelect is not valued", 10);
  Book RECORD_2 = new Book(2L, "Fahrenhit 451", "Books are illegal", 8);
  Book RECORD_3 = new Book(3L, "The Giver", "Human suffering is obsolete, so is free will", 6);

  @Before
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
  }

  @Test
  public void getAllRecords_success() throws Exception {
    List<Book> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

    Mockito.when(bookRepository.findAll()).thenReturn(records);

    mockMvc.perform(MockMvcRequestBuilders.get("/book").contentType(MediaType.APPLICATION_JSON));
    // .andExpect(status().isOk())
    // .andExpect(MockMvcResultMatchers.jsonPath("S", (3)));
    // .andExpect(jsonPath("$[2].name", is("Fahrenhit 451")));
  }
}
