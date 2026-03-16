# Spring Cache Study Basics #

## When can I use Cache ##

- When you need to list the same thing a lot
- When you need to load configuration files everytime any service is running
- When your application just need to load the exact same data to run some part of your program
    - Like at Spring integration used in Maker, we use cache to load whenever you run the same operation of a client more than once. We load once the mapOfParams, then on the next execution it will load the cache data
- And more...

### Spring Cache Annotations ###

- `@Cacheable` - Cacheia o método inteiro baseado em parâmetros passados como "cacheNames", "cacheManager" e condition
- `@CachePut` - Atualiza o Cache com o resultado do método
- `@CacheEvict` - Remove dados do Cache
- `@Caching` - Permite utilizar mais de uma anotação de cache, por exemplo o `@Cacheable` e `@CachePut` ao mesmo tempo

## Reference ##

I'm using this spring cache guide as I'm studying at maker, but I have a repo on that same topic utilizing H2 Database and Redis to simulate real world implementation

[SpringIO Doc](https://spring.io/guides/gs/caching)

[Github Repo](https://github.com/Marcelolinho/spring-cache-study)

[Medium Article](https://medium.com/@AlexanderObregon/a-practical-introduction-to-cacheable-cacheevict-and-other-cache-related-annotations-in-spring-f000f4331e2e)