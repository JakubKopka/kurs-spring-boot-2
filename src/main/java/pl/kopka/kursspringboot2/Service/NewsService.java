package pl.kopka.kursspringboot2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.kopka.kursspringboot2.Client.ClientController;
import pl.kopka.kursspringboot2.Client.Mapper;
import pl.kopka.kursspringboot2.Dao.NewsDaoImp;
import pl.kopka.kursspringboot2.Model.Client.NewsApi;
import pl.kopka.kursspringboot2.Model.News;

import java.util.List;

@Service
public class NewsService {

    private NewsDaoImp newsDaoImp;
    private ClientController clientController;
    private Mapper mapper;

    @Autowired
    public NewsService(NewsDaoImp newsDaoImp, ClientController clientController, Mapper mapper) {
        this.newsDaoImp = newsDaoImp;
        this.clientController = clientController;
        this.mapper = mapper;
    }

    public List<News> getAll() {
        return newsDaoImp.findAll();
    }


    @EventListener(ApplicationReadyEvent.class)
    public void addNewsFromClientToDatabse(){
        List<News> newsList = newsDaoImp.findAll();
        if(newsList.size() == 0){
            List<NewsApi> newsApis = clientController.getNewsFormApi();
            newsApis.stream().forEach(element -> {
                newsDaoImp.save(mapper.mapToNews(element));
            });
            System.out.println("End of addNewsFromClientToDatabse");
        }
    }

    public News getNewsById(String id) {
        return newsDaoImp.getNewsById(id);
    }


    public boolean editNews(News news) {
        return newsDaoImp.edit(news);
    }
}
