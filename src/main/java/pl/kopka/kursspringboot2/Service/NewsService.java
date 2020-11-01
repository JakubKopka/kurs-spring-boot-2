package pl.kopka.kursspringboot2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kopka.kursspringboot2.Dao.NewsDaoImp;
import pl.kopka.kursspringboot2.Model.News;

import java.util.List;

@Service
public class NewsService {

    private NewsDaoImp newsDaoImp;

    @Autowired
    public NewsService(NewsDaoImp newsDaoImp) {
        this.newsDaoImp = newsDaoImp;
    }

    public List<News> getAll() {
        return newsDaoImp.findAll();
    }

}
