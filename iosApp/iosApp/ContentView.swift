import UIKit
import SwiftUI
import IosKmpApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        NSLog(Greeting().greet())
        NSLog(DataGreeting().greet())
        return KmpViewControllerKt.KmpViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
    }
}

struct ContentView: View {
    var body: some View {
        ComposeView()
            .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}



