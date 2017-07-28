package me.leo;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean Finalizar = false;

		// Cliente cadastrado
		Cliente Leo = new Cliente();
		Leo.setNome("Leonardo");
		Leo.setSenha("123");
		Leo.setEmail("leo@leo.com");

		// Definindo Itens
		Produto Notebook = new Produto();
		Produto Celular = new Produto();
		Produto DeskTop = new Produto();

		Notebook.setNome("Samsung");
		Notebook.setPreco(2000);
		Notebook.setCategorias("NoteBook");

		Celular.setNome("MotoG");
		Celular.setPreco(1000);
		Celular.setCategorias("Celular");

		DeskTop.setNome("HP");
		DeskTop.setPreco(1200);
		DeskTop.setCategorias("DeskTop");

		
		//Adicionando os Itens no catalogo.
		Produto[] Lista = new Produto[4];
		Lista[1] = Notebook;
		Lista[2] = Celular;
		Lista[3] = DeskTop;
		
		
		//Sistema
		while (!Finalizar) {

			//Funções do Sistema.
			System.out.println(
					"Escolha a Opção:\n 1- Lista de Produtos.\n 2- Verificar Carrinho.\n 3 - Remover Itens do carrinho\n 4- Finalizar\n ");

			int verificar = sc.nextInt();

			//Verificação das funções
			if (verificar == 1) {

				ListarProdutos(Lista);
				System.out.println("Adicione um item no Carrinho:");
				int Objeto = sc.nextInt();

				for (int i = 1; i < Lista.length; i++) {
					if (i == Objeto) {
						AddCarrinho(Lista[i]);
					}

				}

			} else if (verificar == 2) {

				if (CarrinhoList.isEmpty()) {
					System.out.println("   Nenhum item Adicionado!\n");
				} else {
					VerCarrinho();
				}

			} else if (verificar == 3) {
				if (CarrinhoList.isEmpty()) {
					System.out.println("   Nenhum item Adicionado!\n");
				} else {
					VerCarrinho();
					System.out.println("Remova o item no Carrinho:");
					int Objeto = sc.nextInt();

					removeCarrinho(Objeto);
				}

			} else if (verificar == 4) {
				Finalizar = !Finalizar;
				System.out.println("Finalizado!");
			}
		}

	}
	//Carrinho salvo em sessão.
	static ArrayList<Object> CarrinhoList = new ArrayList<>();

	public static void AddCarrinho(Produto nome) {
		CarrinhoList.add(nome);

	}
	// Remover item Especifico
	public static void removeCarrinho(int i) {
		CarrinhoList.remove(i);

	}
	// checar Itens salvos em sessão.
	public static void VerCarrinho() {
		double total = 0;
		double desconto = 0;
		for (int i = 0; i < CarrinhoList.size();) {

			if (CarrinhoList.get(i) != null) {
				Produto produto = (Produto) CarrinhoList.get(i);
				System.out.println("[ " + i + " ][Nome: " + produto.getNome() + " Preço: " + produto.getPreco()
						+ "   Categoria: " + produto.getCategorias() + "]\n");
				total += produto.getPreco();
				i++;
			}
		}

		if (!CarrinhoList.isEmpty()) {

			desconto = total;
			desconto = desconto - (desconto * 0.3);
			System.out.println("Desconto de 30% : " + desconto + "\n");
			System.out.println("Total: " + total + "\n");
		}

	}
	
	//Listagem dos itens
	public static void ListarProdutos(Produto[] list) {
		for (int i = 1; i < list.length; i++) {
			if (list[i] != null) {
				System.out.println("[ " + i + " ][Nome: " + list[i].getNome() + " Preço: " + list[i].getPreco()
						+ "   Categoria: " + list[i].getCategorias() + "]\n");
			}

		}
	}

}
