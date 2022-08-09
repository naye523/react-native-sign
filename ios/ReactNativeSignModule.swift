import ExpoModulesCore
import WalletConnectSign

public class ReactNativeSignModule: Module {
  public func definition() -> ModuleDefinition {
    Name("ReactNativeSign")

    Events("onChange")

    Function("hello") {
      return "Hello world! 👋"
    }

    AsyncFunction("setValueAsync") { (value: String) in
      self.sendEvent("onChange", [
        "value": value
      ])
    }
  }
}
