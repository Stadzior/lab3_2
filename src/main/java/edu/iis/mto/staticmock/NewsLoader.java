package edu.iis.mto.staticmock;

import edu.iis.mto.staticmock.reader.NewsReader;

public class NewsLoader {
	public PublishableNews loadNews(){
		Configuration config = ConfigurationLoader.getInstance().loadConfiguration();
		NewsReader reader = NewsReaderFactory.getReader(config.getReaderType());
		IncomingNews news = reader.read();
		PublishableNews publishable = prepareForPublish(news);
		return publishable;
		
	}

	public PublishableNews prepareForPublish(IncomingNews news) {
		PublishableNews publishable = PublishableNews.create();
		for(IncomingInfo info : news.elems()){
			if(!info.requiresSubsciption()){
				publishable.addPublicInfo(info.getContent());
			}else{
				publishable.addForSubscription(info.getContent(), info.getSubscriptionType());
			}
		}
		
		return publishable;
	}
}
