import edu.iis.mto.staticmock.ConfigurationLoader;
import edu.iis.mto.staticmock.NewsLoader;
import edu.iis.mto.staticmock.NewsReaderFactory;
import edu.iis.mto.staticmock.PublishableNews;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ConfigurationLoader.class,NewsReaderFactory.class})
public class NewsLoaderTest {

    ConfigurationLoader configurationLoader;
    NewsReaderFactory newsReaderFactory;
    PublishableNews publishableNews;
    NewsLoader newsLoader;
    @Before
    public void initialize(){
        newsLoader = new NewsLoader();
        PowerMockito.mockStatic(ConfigurationLoader.class);
        PowerMockito.mockStatic(NewsReaderFactory.class);
        publishableNews = new PublishableNews();
        configurationLoader = PowerMockito.mock(ConfigurationLoader.class);
        newsReaderFactory = PowerMockito.mock(NewsReaderFactory.class);
    }

    @Test
    public void ShouldCallOnceLoadConfigurationMethod_WhenLoadingNews(){

    }

    @Test
    public void ShouldAddNewsToPublicNews_WhenSubscriptionIsNotRequired(){

    }

    @Test
    public void ShouldAddNewsToPrivateNews_WhenSubscriptionIsRequired(){

    }

}
