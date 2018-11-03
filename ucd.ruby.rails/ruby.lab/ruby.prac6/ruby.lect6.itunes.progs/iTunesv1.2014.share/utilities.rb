require_relative 'data'

module Util
  def self.fetch(data, string_item, _out = [])
    all = data.songs + data.actors + data.albums
    found = all.select { |obj| string_item == obj.name }
    if found.empty?
      then MyErr.new('not_found_error', string_item, 'fetch').do_it
    elsif  found.size > 1
      then MyErr.new('multiple_answer_error', string_item, 'fetch').do_it
    elsif  found.size == 1
      then found.first
    end
  end
end

class Array
  def clean_up
    join(' ').split(' ').uniq 
  end
end
