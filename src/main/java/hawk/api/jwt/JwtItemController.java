package hawk.api.jwt;

import hawk.form.Search;
import hawk.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jwt/items")
public class JwtItemController {

    private final SearchService searchService;

    @Autowired
    public JwtItemController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search/")
    public ResponseEntity searchAll() {
        Search search = new Search("");
        return ResponseEntity.ok(searchService.search(search));
    }

    @GetMapping("/search/{text}")
    public ResponseEntity search(@PathVariable("text") String text) {
        Search search = new Search(text);
        return ResponseEntity.ok(searchService.search(search));
    }
}
