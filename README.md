# Kafka com Spring: Simulação de Envio e Recebimento de Pix

Este projeto demonstra a integração entre aplicações utilizando Apache Kafka e Spring Boot para simular o envio e recebimento de transações Pix. Ele abrange a gestão de fluxos de dados, implementação de produtores e consumidores, processamento de streams, uso do Schema Registry, Kafka Connect e Docker.

## Tecnologias Utilizadas

- **Linguagem de Programação**: Java
- **Framework**: Spring Boot
- **Mensageria**: Apache Kafka
- **Processamento de Streams**: Kafka Streams
- **Registro de Esquemas**: Confluent Schema Registry
- **Integração de Conectores**: Kafka Connect
- **Containerização**: Docker

## Funcionalidades

- **Produtor de Mensagens**: Envio de transações Pix para tópicos Kafka.
- **Consumidor de Mensagens**: Leitura e processamento de transações Pix a partir de tópicos Kafka.
- **Processamento de Streams**: Manipulação e transformação de fluxos de dados em tempo real.
- **Schema Registry**: Gerenciamento de esquemas Avro para serialização e desserialização de mensagens.
- **Kafka Connect**: Integração com sistemas externos através de conectores pré-definidos.
- **Ambiente Dockerizado**: Configuração de todo o ambiente utilizando Docker para facilitar a implantação.

## Estrutura do Projeto

O projeto está organizado nos seguintes módulos:

- **pix-produtor**: Aplicação Spring Boot responsável por produzir mensagens de transações Pix e enviá-las para um tópico Kafka.
- **pix-consumidor**: Aplicação Spring Boot que consome mensagens de transações Pix do tópico Kafka e processa as informações.
- **pix-stream**: Aplicação que utiliza Kafka Streams para processar e transformar os dados das transações Pix em tempo real.
- **pix-produtor-connect**: Configuração de um conector Kafka Connect para enviar dados de transações Pix a um sistema externo.
- **pix-consumidor-connect**: Configuração de um conector Kafka Connect para receber dados de um sistema externo e processá-los.
- **pix-consumidor-avro**: Variante do consumidor que utiliza o Schema Registry para gerenciar esquemas Avro.
- **docker**: Arquivos de configuração para criação dos containers Docker necessários para o ambiente.

## Pré-requisitos

- **Java 11** ou superior
- **Apache Maven** para gerenciamento de dependências
- **Docker** e **Docker Compose** para containerização dos serviços

## Como Executar o Projeto

1. **Clonar o Repositório**:
   ```bash
   git clone https://github.com/williammian/kafka-spring.git
   ```

2. **Iniciar os Containers Docker**:
   - Navegue até o diretório `docker`:
     ```bash
     cd kafka-spring/docker
     ```
   - Inicie os serviços definidos no `docker-compose.yml`:
     ```bash
     docker-compose up -d
     ```
   - Isso iniciará os containers do Zookeeper, Kafka, Schema Registry e Kafka Connect.

3. **Executar os Módulos do Projeto**:
   - Cada módulo (`pix-produtor`, `pix-consumidor`, etc.) é uma aplicação Spring Boot independente.
   - Para executar um módulo, navegue até o diretório correspondente:
     ```bash
     cd ../pix-produtor
     ```
   - Compile e execute a aplicação:
     ```bash
     mvn spring-boot:run
     ```
   - Repita este processo para os demais módulos conforme necessário.

## Observações

- Certifique-se de que as portas necessárias (conforme definidas nos arquivos de configuração) estejam livres antes de iniciar os serviços.
- Os arquivos de configuração para cada módulo contêm detalhes específicos sobre tópicos Kafka, grupos de consumidores e configurações de serialização/desserialização.
- Para interagir com o Kafka Connect e gerenciar conectores, utilize as APIs REST fornecidas pelo Kafka Connect.

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo LICENSE para obter mais informações.

