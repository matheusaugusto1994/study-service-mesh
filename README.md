# study-service-mesh

docker-compose up core ui db
docker-compose up linkerd
Apresentação

-------

Apresentação

- Introdução


- Microservices - Arquitetura Orientada a Serviços

Nas palavras de Martin Fowler

"O termo 'Arquitetura de Microsserviços (Microservice Architecture)' surgiu nos últimos anos para descrever uma maneira específica de desenvolver software como suites de serviços com deploy independente. Embora não exista uma definição precisa desse estilo de arquitetura, há certas características comuns em relação à organização, à capacidade de negócios, ao deploy automatizado, à inteligência nos terminais e ao controle descentralizado de linguagens e de dados."

Em outras palavras...

...o estilo de arquitetura de microsserviços é uma abordagem que desenvolve um aplicativo único como uma suite de pequenos serviços, cada um executando seu próprio processo e se comunicando através de mecanismos leves, muitas vezes em uma API com recursos HTTP...

A arquitetura de microservices nos trouxe diversas vantagens...

     - Mais fácil de desenvolver, compreender e manter;
     - Começa mais rápido do que um monolito;
     - Mudanças locais podem ser facilmente implantadas;
     - Escalar de forma independente;
     - Melhora o isolamento de falhas;
     - Etc...

No entanto, também trouxe preocupações que não existiam antes...

     - Provisão rápida de recursos computacionais;
     - Monitoramento básico;
     - Desenvolvimento rápido;
     - Fácil de provisionar armazenamento;
     - Fácil acesso à borda;
     - Autenticação / Autorização;
     - RPC padronizado;

Para piorar existem pressupostos e descuidos no desenvolvimento de microserviços...

     - A rede é confiável;
     - A latência é zero;
     - A largura de banda é infinita;
     - A rede está segura;
     - A topologia não muda;
     - Existe um administrador;
     - O custo do transporte é zero;
     - A rede é homogênea;

Requisitos a serem cumpridos ao desenvolver uma arquitetura orientada a serviços:

- Service discovery Pattern

     ... Processo de encontrar automaticamente quais instâncias de serviço atendem a uma determinada consulta...

     - Cenário onde existe diversos serviços dinamicamente distribuídos na rede;
     - As instâncias de serviços mudam dinamicamente devido a escala automática, falhas, atualizações;
     - Não se tem o controle de endereços IP e nem o nome das instâncias;

     Solução:

     - É usado um registrador (Service Registry) onde é possível localizar o endereço da instância de serviço desejado;


- Circuit Breaking Pattern (Disjuntor)

     - Processo de monitorar determinado serviço avaliando a "saúde" (health) do mesmo;
     - Após um limite pré-determinado de falhas, o disjuntor é desarmado;
     - A partir desse momento todas as chamadas para o mesmo retornam falha;
     - Normalmente este comportamento está relacionado a um alerta de "chave desarmada";

- Retry Pattern

     - Um microservice pode falhar na primeira vez que faz um pedido de outro serviço;
     - Essas falhas podem ter uma vida muito curta;
     - Nesse caso o serviço solicitante é obrigado a entrar no modo de manipulação de falhas;
     - Então é Nova tentativa sem o conhecimento do microservice requerente;
     - Proporciona uma melhor manipulação de falhas;

     Estratégias de repetição:

     - Intervalo fixo: reiniciando a uma taxa fixa.
     - Backoff exponencial: usando esperas progressivamente mais longas entre tentativas.
     - Aleatório: definindo intervalos de repetição aleatória.

     Obs: Deve haver cautela com a escolha de intervalos muito curtos e um número elevado
     de tentativas, pois isso pode ser interpretado como um ataque DOS no serviço.

- Routing (Gateway de API)

     - Um Gateway de API é um servidor que é o único ponto de entrada no sistema;
     - É semelhante ao padrão Fachada do design orientado a objetos;
     - O Gateway da API encapsula a arquitetura interna do sistema e fornece uma API adaptada a cada cliente;
     - Pode ter outras responsabilidades, tais como autenticação, monitoramento, balanceamento de carga, etc;
     - O Gateway da API é responsável pelo roteamento de solicitação, composição e tradução de protocolo;
     - Todas as solicitações dos clientes primeiro passam pelo Gateway da API;
     - Em seguida, encaminha os pedidos para o microservice apropriado;

- Monitoring

     - No contexto de arquitetura orientada a microserviços, monitoramento ajuda a lidar com logs de vários serviços;
     - Fornece em um dashboard uma visão geral real-time dos estado de cada aplicação;
     - Visão geral de cada serviço, interações e erros baseados em HTTP Status Code;
     - Normalmente pode estar vinculado a alertas configuráveis;
     - Integração com ferramentas conhecidas como o Grafana;
     - Não consiste um pattern relacionado à microservices;

- Histórico e Motivações

     - Como os padrões/desafios acima foram implementados/solucionados no passado...

     - Exemplos de novos desafios com a arquitetura orientada a serviços:
          - Service discovery;
          - Circuit Breaker;

     - Estas são excelentes ferrementas para adicionar confiabilidade às interações entre seus serviços;
     - Porém, a complexidade aumenta à medida em que o nível de distribuição aumenta.
     - Com isso foram utilizadas bibliotecas de terceiros para diminuir o nível de complexidade;

     Exemplos:
          - Finagle do Twitter (Lib para resolver cirtuit breaker);
          - Proxygen do Facebook (Lib para resolver service discovery);
          Respectivamente...

     - Este modelo foi utilizado pela maioria das organizações pioneiras na arquitetura orientada a serviços:
          São elas: Netflix, SoundClound e Twitter;

     - Problemas na utilização de libs terceiras:

- Alto custo para contrução de ferramentas utilizadas na estratégia de libs;
- Restringe as plataformas e linguagens, pois muitas vezes são desenvolvidas em linguagem específica;
- Para alterar a plataforma usada é dedicado alto esforço que poderia estar sendo usado no negócio principal da compania;
- Dados esse esforço algumas companias chegaram a padronizar as plataformas usadas internamente, como é o caso da SoundClound e Digital Oceal que padronizaram como linguagens de desenvolvimento Scala e GO respectivamente;
- Governaça: atualização das bibliotecas. É necessário ter cuidados extras.

- Próximo Passo:

     - Separar esforço  dedicado à lógica de negócio dos serviços do trabalho de escrever código de infra-estrutura de serviços ou gerenciamento de bibliotecdas;

- Solução baseada em Libs:

     - Proxies: Os serviços se comunicam através de um módulo por meio de libs e frameworks;
     - Sidecar: Conceito onde existe um processo auxiliar nas pontas dos serviços;

     - Exemplos:
          Prana do Netflix;

- Em contra-partida...

     -  Embora existam muitas implementações do conceito Sidecar, elas tendem a ser projetadas para trabalhar com componentes específicos.

     Exemplos:
          - Para service discovery, o Nerve & Sinapse da AirBnB assume que os serviços estejam registrados no ZooKeeper;
          - O Prana do Twitter, para circuite breaker, exige que o próprio registro de serviços Eureka seja utilizado;

     Em ambos os casos é necessário alteração da aplicação...

- Evolução out-of-box:

     - Com a crescente popularidade da arquitetura de microservices, recentemente vimos uma onda de proxies que são flexíveis o suficiente para se adaptar a diferentes componetes (plataformas) e infra-estruturas:

     Linkerd (Buoyant): foi o primeiro amplamente conhecido, com base no trabalho anterior de seus engenheiros na plataforma de microservices do Twtitter;

     Envoy (Lyft - Similar ao Uber);

- Service Mesh

     - Padrão de comunicação entre serviços que visa diminuir a complexidade de integração;
     - O controle de fluxo de dados pe feito fora do código da aplicaçãoi (out-of-the-box);
     - miniminiza problemas surgidos com a arquitetura orientada à microserviços;
          - Provisionamento/Escalonabilidade;
          - Monitoramento;
          - Deployment;
          - Autenticação/Autorização;
          - Comunicação padronizada;

- Linkerd

     - Introdução;
     - Execução (sh, docker, docker-compose, kubernetes);
     - YAML;
     - Service Discovery / Routing;
     - Circuit breaker;
     - Retries;
     - Monitoring;
          - Dashboard default;
          - Grafana;

- Passos:

          - remoção Zuul (router)
          - remoção do heureka (service discovery)
          - remoção do Histriz
          - Implementação do Service Discovery (Dtab)
          - Implementação do Circuit Breaker (failureAccrual)
          - Implementação do Retry (retries)
          - linkerd on docker-compose

- POC (resultados)

- Kubernets

- Conduit

- Links úteis;

- Referências