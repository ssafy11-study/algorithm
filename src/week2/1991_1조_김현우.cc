#include <iostream>
#include <queue>

using namespace std;

struct Node {
	char data;
	Node* left;
	Node* right;
};

queue<Node*> insert_q;

Node* create(char data) {
	Node* newNode = new Node();
	newNode->data = data;
	newNode->left = nullptr;
	newNode->right = nullptr;
	return newNode;
}

void Insert(Node* node, char left, char right) {
	if (left != '.') {
		node->left = create(left);
		insert_q.push(node->left);
	}
	if (right != '.') {
		node->right = create(right);
		insert_q.push(node->right);
	}
}

void preorder(Node* node) {
	if (node == NULL) return;
	cout << node->data;
	preorder(node->left);
	preorder(node->right);
}

void inorder(Node* node) {
	if (node == NULL) return;
	inorder(node->left);
	cout << node->data;
	inorder(node->right);
}

void postorder(Node* node) {
	if (node == NULL) return;
	postorder(node->left);
	postorder(node->right);
	cout << node->data;
}

int main(void) {
    cin.tie(NULL);
    cout.tie(NULL);
	int N;
	char first, second, third;
	insert_q.push(create('A'));
	Node* root = insert_q.front();
	cin >> N;
	Node* n;
	for (int i = 0; i < N; i++) {
		cin >> first >> second >> third;
		n = insert_q.front();
		insert_q.pop();
		while (n->data != first) {
			insert_q.push(n);
			n = insert_q.front();
			insert_q.pop();
		}
		Insert(n, second, third);
	}
	preorder(root);
	cout <<"\n";
	inorder(root);
	cout <<"\n";
	postorder(root);
}