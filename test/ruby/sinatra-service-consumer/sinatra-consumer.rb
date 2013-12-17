require 'sinatra/base'

class SinatraConsumer < Sinatra::Base
  get '/' do
    "Sinatra Trapperkeeper Service Consumer!"
  end

  run! if app_file == $0
end
