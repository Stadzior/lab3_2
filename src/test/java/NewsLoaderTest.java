import edu.iis.mto.staticmock.*;
import edu.iis.mto.staticmock.reader.NewsReader;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.anyString;

import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ConfigurationLoader.class,NewsReaderFactory.class})
public class NewsLoaderTest {

    ConfigurationLoader configurationLoader;
    NewsReaderFactory newsReaderFactory;
    PublishableNews publishableNews;
    NewsLoader newsLoader;
    IncomingNews incomingNews;
    NewsReader newsReader;
    @Before
    public void initialize(){
        incomingNews = new IncomingNews();
        newsLoader = new NewsLoader();

        PowerMockito.mockStatic(ConfigurationLoader.class);
        PowerMockito.mockStatic(NewsReaderFactory.class);

        configurationLoader = PowerMockito.mock(ConfigurationLoader.class);
        when(ConfigurationLoader.getInstance()).thenReturn(configurationLoader);
        when(configurationLoader.loadConfiguration()).thenReturn(new Configuration());

        newsReader = PowerMockito.mock(NewsReader.class);
        when(newsReader.read()).thenReturn(incomingNews);
        when(NewsReaderFactory.getReader(anyString())).thenReturn(newsReader);

        incomingNews.add(new IncomingInfo("A", SubsciptionType.A));
        incomingNews.add(new IncomingInfo("B", SubsciptionType.B));
        incomingNews.add(new IncomingInfo("NONE", SubsciptionType.NONE));

        publishableNews = newsLoader.prepareForPublish(incomingNews);
    }

    @Test
    public void ShouldCallOnceLoadConfigurationMethod_WhenLoadingNews(){
        
        PowerMockito.verifyStatic();
    }

    @Test
    public void NewsPublishContentFilteringTest(){

        Assert.assertThat(publishableNews.publicContent.size(),equalTo(1));

    }

    @Test
    public void NewsSubscribentContentFilteringTest(){

        Assert.assertThat(publishableNews.subscribentContent.size(),equalTo(2));

    }


}
