<div class="delegacaos view">
<h2><?php echo __('Delegacao'); ?></h2>
	<dl>
		<dt><?php echo __('Id'); ?></dt>
		<dd>
			<?php echo h($delegacao['Delegacao']['id']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Nome'); ?></dt>
		<dd>
			<?php echo h($delegacao['Delegacao']['nome']); ?>
			&nbsp;
		</dd>
	</dl>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('Edit Delegacao'), array('action' => 'edit', $delegacao['Delegacao']['id'])); ?> </li>
		<li><?php echo $this->Form->postLink(__('Delete Delegacao'), array('action' => 'delete', $delegacao['Delegacao']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $delegacao['Delegacao']['id']))); ?> </li>
		<li><?php echo $this->Html->link(__('List Delegacaos'), array('action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Delegacao'), array('action' => 'add')); ?> </li>
	</ul>
</div>
