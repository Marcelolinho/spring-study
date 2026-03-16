import json
import requests
from bs4 import BeautifulSoup

response = requests.get('https://news.ycombinator.com/')
soup = BeautifulSoup(response.text, 'html.parser')
articles = soup.find_all(class_='athing')

output = []
for article in articles:
    data = {
        'URL': article.find(class_='titleline').find('a').get('href'),
        'title': article.find(class_='titleline').getText(),
        'rank': article.find(class_='rank').getText().replace('.', '')
    }
    output.append(data)

print(json.dumps(output, indent=2, ensure_ascii=False))