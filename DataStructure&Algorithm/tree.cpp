#include<bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
using namespace __gnu_pbds;
using namespace std;

#define ff              first
#define ss              second
#define int             long long
#define pb              push_back
#define mp              make_pair
#define pii             pair<int,int>
#define vi              vector<int>
#define mii             map<int,int>
#define pqb             priority_queue<int>
#define pqs             priority_queue<int,vi,greater<int> >
#define setbits(x)      __builtin_popcountll(x)
#define zrobits(x)      __builtin_ctzll(x)
#define mod             1000000007
#define inf             1e18
#define ps(x,y)         fixed<<setprecision(y)<<x
#define mk(arr,n,type)  type *arr=new type[n];
#define w(x)            int x; cin>>x; while(x--)
mt19937                 rng(chrono::steady_clock::now().time_since_epoch().count());

typedef tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update> pbds;
void c_p_c()
{
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
}

struct node {
    node *left, *right;
    char label;
};

node* createNode(int val){
    node* newNode = new node;
    newNode -> label = val;
    newNode -> left = nullptr;
    newNode -> right = nullptr;
    return newNode;
};

node* insert(node* root, int val){
    if (root == nullptr){
        return createNode(val);
    }

    if (val < root -> label){
        root -> left = insert(root -> left, val);
    }
    else if (val > root -> label){
        root -> right = insert(root -> right, val);
    }

    return root;
};

void inorder(node* root) {
    if (root != nullptr) {
        inorder(root->left);
        std::cout << root->label << " ";
        inorder(root->right);
    }
}

int32_t main()
{
    //c_p_c();
    node* root = nullptr;

    // Inserting nodes into the binary tree
    root = insert(root, 'A');
    insert(root, 'B');
    insert(root, 'C');
    insert(root, 'D');
    insert(root, 'E');
    insert(root, 'F');
    insert(root, 'G');

    // Performing in-order traversal
    std::cout << "Inorder traversal: ";
    inorder(root);
    std::cout << std::endl;

    return 0;
}