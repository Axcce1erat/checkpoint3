package spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/error")
    public String error(Model model) {

        return "Hallo";
    }

    @GetMapping("/book")
    public String book(Model model) {

        return "book";
    }

    @GetMapping("/")
    public String root(Model model) {

        return "book";
    }

    @GetMapping("/save")
    public String save(Model model, @RequestParam String title, @RequestParam String author) {

        Book tmpBook = new Book(title, author);

        bookRepository.save(tmpBook);

        return "redirect:/books";
    }

    @GetMapping("/books")
    public String books(Model model) {

        List<Book> tmpBook;

        tmpBook = bookRepository.findAll();

        model.addAttribute("booklist", tmpBook);
        return "books";
    }

    @GetMapping("/search")
    public String search(Model model) {

        return "search";
    }

    @GetMapping("/search-title")
    public String search_title(Model model, @RequestParam String title) {

        List<Book> tmpBook;
        Book tmp = null;
        tmpBook = bookRepository.findAll();

        for (int i = 0; i < tmpBook.size(); i++) {
            if (tmpBook.get(i).getTitle().equals(title)) {
                tmp = tmpBook.get(i);
            }
        }

        model.addAttribute("author", tmp.getAuthor());
        model.addAttribute("id", tmp.getId());
        model.addAttribute("title", tmp.getTitle());

        return "search_title";
    }

    @GetMapping("/search-author")
    public String search_author(Model model, @RequestParam String author) {

        List<Book> tmpBook;
        Book tmp = null;
        tmpBook = bookRepository.findAll();

        for (int i = 0; i < tmpBook.size(); i++) {
            if (tmpBook.get(i).getAuthor().equals(author)) {
                tmp = tmpBook.get(i);
            }
        }

        model.addAttribute("author", tmp.getAuthor());
        model.addAttribute("id", tmp.getId());
        model.addAttribute("title", tmp.getTitle());

        return "search_author";
    }

}
