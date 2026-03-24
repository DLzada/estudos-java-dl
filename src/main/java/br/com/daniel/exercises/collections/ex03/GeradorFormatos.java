package collections.ex03;

import java.util.List;

public class GeradorFormatos {

    public static String paraJson(List<Campo> campos) {
        StringBuilder sb = new StringBuilder("{\n");
        for (int i = 0; i < campos.size(); i++) {
            Campo c = campos.get(i);
            sb.append("  \"").append(c.getNome()).append("\": ");

            if (c.getTipo().equals("texto") || c.getTipo().equals("data") || c.getTipo().contains("hora")) {
                sb.append("\"").append(c.getValor()).append("\"");
            } else {
                sb.append(c.getValor());
            }

            if (i < campos.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

    public static String paraXml(List<Campo> campos) {
        StringBuilder sb = new StringBuilder("<registro>\n");
        for (Campo c : campos) {
            sb.append("  <").append(c.getNome()).append(">")
                    .append(c.getValor())
                    .append("</").append(c.getNome()).append(">\n");
        }
        sb.append("</registro>");
        return sb.toString();
    }

    public static String paraYaml(List<Campo> campos) {
        StringBuilder sb = new StringBuilder("---\n");
        for (Campo c : campos) {
            sb.append(c.getNome()).append(": ").append(c.getValor()).append("\n");
        }
        return sb.toString();
    }
}