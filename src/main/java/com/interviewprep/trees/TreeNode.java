package com.interviewprep.trees;

import java.util.List;
import java.util.ArrayList;

public class TreeNode {
    int val;
    List<TreeNode> children;
    TreeNode(int x) {
        val = x;
        this.children = new ArrayList<>();
    }
}
