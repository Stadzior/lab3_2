import edu.iis.mto.staticmock.Configuration;
import edu.iis.mto.staticmock.ConfigurationLoader;
import edu.iis.mto.staticmock.NewsReaderFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ConfigurationLoader.class,NewsReaderFactory.class})
public class NewsLoaderTest {
    ConfigurationLoader configurationLoader;
    NewsReaderFactory newsReaderFactory;
    @Before
    public void initialize(){
        configurationLoader = Mockito.mock(ConfigurationLoader.class);
        newsReaderFactory = Mockito.mock(NewsReaderFactory.class);
    }
}
