package ru.luckoff.siaod_3;

import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите желаемый корень дерева: ");
        int n = in.nextInt();

        Node node = new Node(n);
        node.left = new Node(4);
        node.left.right = new Node(2);
        node.left.left = new Node(34);
        node.right = new Node(5);
        node.right.left = new Node(33);

        System.out.println("Меню:" +
                "\n1 - Добавить рандомный элемент слева" +
                "\n2 - Вывести бинарное дерево" +
                "\n3 - Узнать высоту дерева" +
                "\n4 - Найти среднее арифмитическое дерева" +
                "\n5 - Узнать количество ребер дерева");

        while (true) {
            System.out.print("Номер: ");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    node.add(node);
                    break;
                case 2:
                    node.output(node, 0);
                    break;
                case 3:
                    System.out.println("Высота дерева: " + node.highTree(node));
                    break;
                case 4:
                    System.out.println("Среднее арифметическое: " + (node.calcKey(node) / node.count(node)));
                    break;
                case 5:
                    System.out.println("Количество ребер: " + node.count(node));
                    break;
                default:
                    break;
            }
        }
    }
}

class Node {
    int key;
    Node left;
    Node right;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    void output(Node node, int l) {
        if (node != null) {
            output(node.right, l+1);
            for (int i = 1; i <= l; i ++)
                System.out.print("  ");
            System.out.print(node.key + "\n");
            output(node.left, l+1);
        }
    }

    void add(Node node) {
        Random random = new Random();
        int elem = random.nextInt(90);
        node.left.left.left = new Node(elem);
        System.out.println("Слева был добавлен новый элемент: " + elem);
    }

    int highTree(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(highTree(node.left), highTree(node.right));
        }
    }

    int count(Node node) {
        if (node != null) {
            return count(node.left) + count(node.right) + 1;
        } else {
            return 0;
        }
    }

    int calcKey(Node node) {
        if (node != null) {
            return calcKey(node.left) + calcKey(node.right) + node.key;
        } else {
            return 0;
        }
    }
}


