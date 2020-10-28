## Enunciado
1. Analise a aplicação de árvores fornecida e para cada funcionalidade apresente dois trechos diferentes de código descrevendo o objetivo de cada um, o que cada um permite e proíbe do ponto de vista do programador, a diferença entre os dois trechos em termos de funcionalidade e argumente a necessidade do trecho do código:
    - (0.2 pontos).Herança;
    - (0.2 pontos).Encapsulamento;
    - (0.2 pontos).Polimorfismo.

## R. Herança:
### Trecho 1
Nesse primeiro trecho de código, temos um peçado do código de implementação da classe BinarySearchTree que herda a classe BinaryTree, em especial seu método add, que é especialidada através de polimorfismo, mas faz uso de herança em seu interior.
```
package tree;

public class BinarySearchTree extends BinaryTree {

	(...)

	@Override
	public boolean add(int value) {
		if (isEmpty()) {
			root = new Node(value);
		} else {
			Node node = getNode(root, value);
			if (value < node.value) {
				node.left = new Node(value);
			} else if (value > node.value) {
				node.right = new Node(value);
			} else {
				return false;
			}
		}
		return true;
	}

	(...)

}
```
- Objetivo: Nesse caso o novo método add, que etá substituindo o método importado da classe herdada, faz a chamada de dois membros da classe herdada, a propriedade root, que da acesso a raiz da árvore, e o método isEmpty, que verifica se a arvore é vazia.
- Permite: Fazer uso de membros da classe herdada (como root e isEmpty), sem a necessidade de reescrever o código desses membros.
- Proíbe: Nesse a herança está sendo utilizada como uma forma de especialização, mas nos casos em que é feita com o único intuíto de reaproveitar código, pode ser que ocorra a necessidade de quebrar o emcapsulamento de métodos e propriedades da classe herdada, para que a classe herdeira tenha acesso a eles e consiga fazer outras implementações, isso torna-se um ponto negativo, pois quebra os princípios da orientação ao objeto.
- Necessidade: o trecho é necessário nesse contexto de especialização da classe BinaryTree em uma Arvore Binária de Busca, sem a necessidade de reescrever ou copiar e adaptar o código original da classe BinaryTree.

### Trecho 2
```
package tree;

public class NodeWithParent extends Node {

	protected NodeWithParent parent;

	public NodeWithParent(NodeWithParent parent, int value) {
		super(value);
		this.parent = parent;
	}

	public boolean hasParent() {
		return parent != null;
	}
}
```
- Objetivo: Extender as funcionalidades da classe Node, para que ela possa agora ter uma referência para o nó que a precede na arvore. Aqui vemos o uso de herança nas dentro do método construtor "NodeWithParent", onde vemos a chamda do "super" para chamar o construtor da classe herdada, e da propriedade "this.parent" que é membro da classe herdada, mas pode ser chamda pela classe herdeira, pois é protected.
- Permite: Que uma nova classe, nesse caso NodeWithParent, seja criada usando como base a classe Node, sem a necessidade de criar duas bases de código, apenas extendendo a base já existente através da herança e tendo acessos a métodos e propriedades da classe original.
- Proíbe: Nesse caso, por exemplo, provavelmente foi necessaário modificar a classe Node, mudando suas propriedades privadas para protected, para que a classe herdeira possa ter acesso a esses membros.
- Necessidade: Torna-se necessário pois a classe Node, a pesar de ter a referência para o parente, não implementa as funcionalidade que esta classe implementou de modo a essa referência de modo adequado.
<br>
- Diferença entre os dois trechos: No caso do primeiro exemplo vemos uma situação de extensão pura, onde a classe herdeira não precisou acessar nenhum membro emcapsulado na classe herdada, no segundo caso, a necessidade de acessar um membro encapsulado torna a implementação um pouco diferente.

## R. Encapsulamento:
### Trecho 1
```
teste
```
- Objetivo:
- Permite:
- Proíbe:
- Necessidade:

### Trecho 2
```
teste
```
- Objetivo:
- Permite:
- Proíbe:
- Necessidade:
<br>
- Diferença entre os dois trechos:

## R. Polimorfismo:
### Trecho 1
```
teste
```
- Objetivo:
- Permite:
- Proíbe:
- Necessidade:

### Trecho 2
```
teste
```
- Objetivo:
- Permite:
- Proíbe:
- Necessidade:
<br>
- Diferença entre os dois trechos:
