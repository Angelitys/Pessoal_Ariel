package br.edu.unisep.gerenciamento.model;

import javax.swing.*;
import java.util.ArrayList;

public class GerenciadorDeTarefas {

    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<>();
        int opcao;

        do {
            // Exibe o menu principal
            String menu = "Selecione uma opção:\n"
                    + "1. Adicionar tarefa\n"
                    + "2. Marcar tarefa como concluída\n"
                    + "3. Remover tarefa\n"
                    + "4. Exibir todas as tarefas\n"
                    + "5. Sair";
            String input = JOptionPane.showInputDialog(menu);

            if (input == null || input.isEmpty()) {
                break;
            }

            try {
                opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1:
                        adicionarTarefa(tarefas);
                        break;
                    case 2:
                        marcarConcluida(tarefas);
                        break;
                    case 3:
                        removerTarefa(tarefas);
                        break;
                    case 4:
                        exibirTarefas(tarefas);
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Saindo do programa...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.");
                opcao = -1; // Valor inválido para continuar o loop
            }
        } while (true);
    }


    private static void adicionarTarefa(ArrayList<String> tarefas) {
        String novaTarefa = JOptionPane.showInputDialog("Digite a nova tarefa:");
        if (novaTarefa != null && !novaTarefa.trim().isEmpty()) {
            tarefas.add(novaTarefa.trim());
            JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Tarefa inválida. Não foi adicionada.");
        }
    }

    private static void marcarConcluida(ArrayList<String> tarefas) {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há tarefas para marcar como concluída.");
            return;
        }

        StringBuilder listaTarefas = new StringBuilder("Tarefas:\n");
        for (int i = 0; i < tarefas.size(); i++) {
            listaTarefas.append(i + 1).append(". ").append(tarefas.get(i)).append("\n");
        }

        String input = JOptionPane.showInputDialog(listaTarefas + "Selecione o número da tarefa a ser marcada como concluída:");
        try {
            int indice = Integer.parseInt(input) - 1;
            if (indice >= 0 && indice < tarefas.size()) {
                tarefas.set(indice, tarefas.get(indice) + " (Concluída)");
                JOptionPane.showMessageDialog(null, "Tarefa marcada como concluída!");
            } else {
                JOptionPane.showMessageDialog(null, "Número inválido. Nenhuma tarefa foi marcada.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Nenhuma tarefa foi marcada.");
        }
    }

    private static void removerTarefa(ArrayList<String> tarefas) {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há tarefas para remover.");
            return;
        }

        StringBuilder listaTarefas = new StringBuilder("Tarefas:\n");
        for (int i = 0; i < tarefas.size(); i++) {
            listaTarefas.append(i + 1).append(". ").append(tarefas.get(i)).append("\n");
        }

        String input = JOptionPane.showInputDialog(listaTarefas + "Selecione o número da tarefa a ser removida:");
        try {
            int indice = Integer.parseInt(input) - 1;
            if (indice >= 0 && indice < tarefas.size()) {
                tarefas.remove(indice);
                JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Número inválido. Nenhuma tarefa foi removida.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Nenhuma tarefa foi removida.");
        }
    }


    private static void exibirTarefas(ArrayList<String> tarefas) {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há tarefas cadastradas.");
        } else {
            StringBuilder listaTarefas = new StringBuilder("Tarefas:\n");
            for (int i = 0; i < tarefas.size(); i++) {
                listaTarefas.append(i + 1).append(". ").append(tarefas.get(i)).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaTarefas.toString());
        }
    }
}
