package com.self;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * This file is used to get the closest common manager between 2 employees in org
 */
public class ClosestManager {

	public static void main(String[] args) {

	}

	private static Org_Employee closestCommonManager(Org_Employee ceo, Org_Employee employee1, Org_Employee employee2) {
		
		Stack<Org_Employee> firstPath = new Stack<>();
		Stack<Org_Employee> secondPath = new Stack<>();

		//DepthFirstSearch
		DFS(ceo, employee1, firstPath);
		DFS(ceo, employee2, secondPath);

		if (firstPath.peek().getId() == employee1.getId() && secondPath.peek().getId() == employee2.getId()) {
			int size1 = firstPath.size();
			int size2 = secondPath.size();
			int diff = Math.abs(size2 - size1);
			if (size1 > size2) {
				moveUp(firstPath, diff);
			} else {
				moveUp(secondPath, diff);
			}
			while (firstPath.peek().getId() != secondPath.peek().getId()) {
				firstPath.pop();
				secondPath.pop();
			}
			if (firstPath.size() > 0) {
				return firstPath.pop();
			}
		}
		return null;
	}

	private static boolean DFS(Org_Employee root, Org_Employee target, Stack<Org_Employee> path) {
		
		path.push(root);
		if (root.getId() == target.getId()) {
			return true;
		}
		for (Org_Employee r : root.getReports()) {
			boolean res = DFS(r, target, path);
			if (res) {
				return true;
			}
		}
		path.pop();
		return false;
	}

	private static void moveUp(Stack<Org_Employee> path, int diff) {
		
		while (diff > 0 && !path.isEmpty()) {
			path.pop();
			diff--;
		}
	}

    class Org_Employee {

        private final int id;
        private final String name;
        private final List<Org_Employee> reports;

        public Org_Employee(int id, String name) {
            this.id = id;
            this.name = name;
            this.reports = new ArrayList<>();
        }

        private int getId() { return id; }

        private String getName() { return name; }

        private List<Org_Employee> getReports() { return reports; }

        public void addReport(Org_Employee employee) { reports.add(employee); }
    }

}