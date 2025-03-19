# Ada Commerce - E-Commerce

Este projeto foi desenvolvido como parte do curso da Ada Tech, com o objetivo de criar um sistema de E-Commerce que gerencia clientes, produtos e vendas. O sistema foi projetado para atender às necessidades de um cliente fictício, seguindo regras de negócio específicas e boas práticas de programação.

## Funcionalidades

- **Gerenciamento de Clientes**:
  - Cadastro, listagem e atualização de clientes.
  - Histórico de clientes mantido sem exclusão.

- **Gerenciamento de Produtos**:
  - Cadastro, listagem e atualização de produtos.
  - Histórico de produtos mantido sem exclusão.

- **Gerenciamento de Vendas**:
  - Criação de vendas para clientes.
  - Adição, remoção e alteração de itens (produtos) no pedido.
  - Realização de pagamentos e entregas.
  - Notificações por e-mail para clientes em diferentes estágios do pedido.

## Regras de Negócio

- Todo cliente deve ter um documento de identificação.
- Pedidos devem ter data de criação e status inicial "Acesso".
- Pedidos com status "Aberto" podem receber itens, alterar quantidades e remover itens.
- Produtos adicionados ao pedido devem ter valor de venda informado.
- Pedidos só podem ser finalizados com pelo menos um item e valor maior que zero.
- Pagamentos só podem ser realizados em pedidos com status "Aguardando pagamento".
- Após o pagamento, o status do pedido é alterado para "Pago" e, posteriormente, para "Finalizado" após a entrega.

## Tecnologias Utilizadas

- Linguagem de programação: [Inserir linguagem, ex: Java, Python, etc.]
- Princípios de Orientação a Objetos e SOLID.
- Base de dados em memória (opcionalmente persistida em arquivos).

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/guibonf1m/Ecommerce_Projeto_POO2.git
