
    $( document ).ready(function() {
      var options = {
            list: [
              ['responsive', 5, 'https://en.wikipedia.org/wiki/Responsive_web_design'],
              ['groovy', 8, 'http://groovy-lang.org/'],
              ['spock', 5, 'http://spockframework.org/'],
              ['spring boot', 7, 'http://spring.io/projects/spring-boot'],
              ['tomcat', 4, 'http://tomcat.apache.org/'],
              ['json', 4, 'https://www.json.org/'],
              ['angular 6', 8, 'https://angular.io/'],
              ['jquery', 5, 'https://jquery.com/'],
              ['nvd3', 7, 'http://nvd3.org/'],
              ['intelliJ', 6, 'https://www.jetbrains.com/idea/'],
              ['ubuntu', 5, 'https://www.ubuntu.com/'],
              ['git', 4, 'https://git-scm.com/'],
              ['quandl', 5, 'http://quandl.com'],
              ['wordcloud2.js', 5, 'https://wordcloud2-js.timdream.org/'],
              ['bootstrap 4', 7, 'https://getbootstrap.com/']
            ],
            color: function() {
              return (['#708090', '#708090' ,'#696969'])[Math.floor(Math.random() * 3)]
            },
            backgroundColor: '#f7f7f7',
            fontFamily: 'Inconsolata, monospace',
            weightFactor: function (size) {
                return Math.pow(size, 2.2) * $('#canvas').width() / 1024;
              },
            click: function(item) {
              window.open(item[2],'_blank')
              },
            drawOutOfBound: true,
            rotateRatio: 0.5,
            ellipticity: 0.4,
            shuffle: true,
            wait: 250
      };

      var width = document.getElementById("canvasFrame").clientWidth;
      $('.canvas').attr('width', width);

      WordCloud(document.getElementById('canvas'), options );
   }
 );
